#!/usr/bin/env python

from io.crate.udf import UserDefinedScalarFunction, UserDefinedAggregationFunction
from io.crate.operation.aggregation import AggregationState
from io.crate import DataType
from io.crate.metadata import (
    FunctionIdent,
    FunctionInfo,
    DynamicFunctionResolver
)
from java.util import Arrays
from java.lang import Long


class PythonMax(UserDefinedAggregationFunction):

    class PythonMaxState(AggregationState):

        def __init__(self):
            self._value = 0

        def value(self):
            return Long(self._value)

        def add(self, value):
            if not value:
                return
            if not self._value:
                self._value = value
            elif value > self._value:
                self._value = value

        def reduce(self, other):
            if other:
                self.add(other.value())

        def readFrom(self, input_stream):
            self._value = input_stream.readLong()

        def writeTo(self, output_stream):
            output_stream.writeLong(self._value)


    def name(self):
        return 'python_max'

    def ident(self):
        return FunctionIdent(self.name(), Arrays.asList(DataType.INTEGER))

    def info(self):
        return FunctionInfo(self.ident(), DataType.LONG, True)

    def dynamicFunctionResolver(self):
        return None

    def normalizeSymbol(self, symbol):
        return symbol

    def iterate(self, state, inputs):
        state.add(inputs[0].value())

    def newState(self):
        return self.PythonMaxState()


class MathMin(UserDefinedScalarFunction):

    NAME = 'math_min'

    class MathMinResolver(DynamicFunctionResolver):
        def getForTypes(self, data_types):
            return MathMin(FunctionInfo(
                FunctionIdent(MathMin.NAME, data_types), data_types[0]))

    def __init__(self, info=None):
        self._info = info

    def name(self):
        return MathMin.NAME

    def ident(self):
        return None

    def info(self):
        return self._info

    def normalizeSymbol(self, symbol):
        return symbol

    def dynamicFunctionResolver(self):
        return MathMin.MathMinResolver()

    def evaluate(self, args):
        return Long(min(args[0].value(), args[1].value()))
