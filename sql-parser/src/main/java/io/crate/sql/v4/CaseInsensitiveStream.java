package io.crate.sql.v4;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.NotNull;

class CaseInsensitiveStream
        implements CharStream
{
    private CharStream stream;

    public CaseInsensitiveStream(CharStream stream)
    {
        this.stream = stream;
    }

    @Override
    @NotNull
    public String getText(@NotNull Interval interval)
    {
        return stream.getText(interval);
    }

    @Override
    public void consume()
    {
        stream.consume();
    }

    @Override
    public int LA(int i)
    {
        int result = stream.LA(i);

        switch (result) {
            case 0:
            case CharStream.EOF:
                return result;
            default:
                return Character.toUpperCase(result);
        }
    }

    @Override
    public int mark()
    {
        return stream.mark();
    }

    @Override
    public void release(int marker)
    {
        stream.release(marker);
    }

    @Override
    public int index()
    {
        return stream.index();
    }

    @Override
    public void seek(int index)
    {
        stream.seek(index);
    }

    @Override
    public int size()
    {
        return stream.size();
    }

    @Override
    @NotNull
    public String getSourceName()
    {
        return stream.getSourceName();
    }
}
