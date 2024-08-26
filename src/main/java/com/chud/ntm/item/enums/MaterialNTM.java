package com.chud.ntm.item.enums;

public enum MaterialNTM {
    steel, titanium, copper, red_copper, advanced_alloy, tungsten, aluminium, beryllium, cdalloy, cadmium, zirconium, boron, firebrick;

    public String lowercase() {
        return toString().toLowerCase();
    }

    public String UPPERCASE() {
        return toString().toUpperCase();
    }

    public String snake_case() {
        return toString();
    }

    public String PascalCase() {
        String[] words = toString().split("_");
        StringBuilder pascalCase = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            pascalCase
                .append(Character.toUpperCase(words[i].charAt(0)))
                .append(words[i].substring(1).toLowerCase());
        }

        return pascalCase.toString();
    }
}
