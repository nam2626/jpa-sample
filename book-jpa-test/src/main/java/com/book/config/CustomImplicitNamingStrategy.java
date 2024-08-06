package com.book.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl;
import org.hibernate.boot.spi.MetadataBuildingContext;

public class CustomImplicitNamingStrategy extends ImplicitNamingStrategyComponentPathImpl {
    @Override
    protected Identifier toIdentifier(String stringForm, MetadataBuildingContext buildingContext) {
        return super.toIdentifier(addUnderscores(stringForm), buildingContext);
    }

    protected static String addUnderscores(String name) {
        final StringBuilder result = new StringBuilder(name.replace('.', '_'));
        for (int i = 1; i < result.length() - 1; i++) {
            if (Character.isLowerCase(result.charAt(i - 1)) &&
                    Character.isUpperCase(result.charAt(i)) &&
                    Character.isLowerCase(result.charAt(i + 1))) {
                result.insert(i++, '_');
            }
        }
        return result.toString().toLowerCase();
    }
}
