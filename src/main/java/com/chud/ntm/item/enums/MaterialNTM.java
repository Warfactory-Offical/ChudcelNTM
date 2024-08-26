package com.chud.ntm.item.enums;

public enum MaterialNTM {
    steel,
    titanium,
    copper,
    red_copper,
    advanced_alloy,
    tungsten,
    aluminium,
    beryllium,
    lead,
    asbestos,
    magnetized_tungsten,
    combine_steel,
    dura_steel,
    technetium,
    tcalloy,
    cdalloy,
    polymer,
    bakelite,
    rubber,
    biorubber,
    desh,
    saturnite,
    ferrouranium,
    starmetal,
    osmiridium,
    euphemium,
    dineutronium,
    cadmium,
    bismuth,
    arsenic,
    zirconium,
    th232,
    uranium,
    u233,
    u235,
    u238,
    u238m2,
    plutonium,
    pu238,
    pu239,
    pu240,
    pu241,
    pu_mix,
    am241,
    am242,
    am_mix,
    schraranium,
    schrabidium,
    schrabidate,
    solinium,
    thorium_fuel,
    uranium_fuel,
    mox_fuel,
    plutonium_fuel,
    neptunium_fuel,
    americium_fuel,
    les,
    schrabidium_fuel,
    hes,
    neptunium,
    tennessine,
    polonium,
    phosphorus,
    boron,
    graphite,
    fiberglass,
    smore,
    niobium,
    actinium,
    neodymium,
    bromine,
    caesium,
    cerium,
    lanthanium,
    tantalium,
    astatine,
    firebrick,
    cobalt,
    co60,
    strontium,
    sr90,
    iodine,
    i131,
    au198,
    pb209,
    ra226,
    ac227,
    gh336,
    radspice,
    electronium,
    reiium,
    weidanium,
    australium,
    verticium,
    unobtainium,
    daffergon,
    steel_dusted,
    chainsteel,
    meteorite,
    meteorite_forged,
    semtex,
    c4;

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
