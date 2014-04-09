#!/usr/bin/env python
# -*- coding: utf-8 -*-

from io.crate.udf import UserDefinedScalarFunction
from io.crate import DataType
from io.crate.metadata import FunctionIdent, FunctionInfo
from java.util import Arrays


class MathMin(UserDefinedScalarFunction):

    def name(self):
        return 'math_min'

    def ident(self):
        return FunctionIdent(self.name(),
                             Arrays.asList(DataType.LONG, DataType.LONG))

    def info(self):
        return FunctionInfo(self.ident(), DataType.LONG)

    def normalizeSymbol(self, symbol):
        return symbol

    def dynamicFunctionResolver(self):
        return None

    def evaluate(self, args):
        return min(args[0].value(), args[1].value())
