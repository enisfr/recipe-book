package com.enisfr.recipebook.converters;


import com.enisfr.recipebook.commands.UnitOfMeasureCommand;
import com.enisfr.recipebook.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {

        final UnitOfMeasureCommand uomc = new UnitOfMeasureCommand();
        uomc.setId(unitOfMeasure.getId());
        uomc.setDescription(unitOfMeasure.getDescription());
        return uomc;
    }
}
