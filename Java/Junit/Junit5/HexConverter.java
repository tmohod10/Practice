package com.company;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.TypedArgumentConverter;

public class HexConverter extends TypedArgumentConverter<String, Integer> {
    protected HexConverter() {
        super(String.class, Integer.class);
    }

    @Override
    protected Integer convert(String source) throws ArgumentConversionException {
        return Integer.parseInt(source, 16);
    }
}
