#!/usr/bin/env python

from io.crate.udf import UserDefinedScalarFunction
from io.crate import DataType
from io.crate.metadata import (
    FunctionIdent,
    FunctionInfo,
    DynamicFunctionResolver
)


class PyEval(UserDefinedScalarFunction):

    class Resolver(DynamicFunctionResolver):
        def getForTypes(self, data_types):
            assert data_types[0] == DataType.STRING
            return PyEval(FunctionInfo(
                FunctionIdent(PyEval.NAME, data_types), DataType.ANY))

    NAME = 'pyeval'

    def __init__(self, info=None):
        self._info = info

    def name(self):
        return PyEval.NAME

    def ident(self):
        return None

    def info(self):
        return self._info

    def normalizeSymbol(self, symbol):
        return symbol

    def dynamicFunctionResolver(self):
        return PyEval.Resolver()

    def evaluate(self, args):
        cmd = args[0].value().utf8ToString()
        if len(args) > 1:
            VALUES = args[1:]
            assert VALUES
        parts = cmd.split(';')
        for part in parts[:-1]:
            exec part
        return eval(parts[-1])
