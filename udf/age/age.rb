require 'java'
java_package 'java.util'
java_package 'io.crate'
java_package 'io.crate.udf'
java_package 'io.crate.metadata'
java_import 'io.crate.udf.UserDefinedScalarFunction'
java_import 'io.crate.metadata.FunctionIdent'
java_import 'io.crate.metadata.FunctionInfo'
java_import 'io.crate.DataType'
java_import 'java.util.Arrays'


class RubyMathMin
    include UserDefinedScalarFunction

    def name
        'ruby_math_min'
    end

    def ident
        FunctionIdent.new(name, Arrays.asList(DataType::LONG, DataType::LONG))
    end

    def info
        FunctionInfo.new(ident, DataType::LONG)
    end

    def dynamicFunctionResolver
    end

    def normalizeSymbol(symbol)
        symbol
    end

    def evaluate(args)
        args.map(&:value).min
    end
end

$RubyMathMin = RubyMathMin
