package com.chud.ntm.item.enums;

@SuppressWarnings("unused")
public enum MaterialNTM {
    ac227,
    actinium,
    advanced_alloy,
    aluminium,
    am241,
    am242,
    am_mix,
    americium_fuel,
    arsenic,
    asbestos,
    astatine,
    au198,
    australium,
    bakelite,
    beryllium,
    biorubber,
    bismuth,
    boron,
    bromine,
    c4,
    cadmium,
    caesium,
    cdalloy,
    cerium,
    chainsteel,
    co60,
    cobalt,
    combine_steel,
    copper,
    daffergon,
    desh,
    dineutronium,
    dura_steel,
    electronium,
    euphemium,
    ferrouranium,
    fiberglass,
    firebrick,
    gh336,
    graphite,
    hes,
    i131,
    iodine,
    lanthanium,
    lead,
    les,
    lithium,
    magnetized_tungsten,
    meteorite,
    meteorite_forged,
    mox_fuel,
    neodymium,
    neptunium,
    neptunium_fuel,
    niobium,
    osmiridium,
    pb209,
    phosphorus,
    plutonium,
    plutonium_fuel,
    polonium,
    polymer,
    pu238,
    pu239,
    pu240,
    pu241,
    pu_mix,
    ra226,
    radspice,
    red_copper,
    reiium,
    rubber,
    saturnite,
    schrabidate,
    schrabidium,
    schrabidium_fuel,
    schraranium,
    semtex,
    smore,
    solinium,
    sr90,
    starmetal,
    steel,
    steel_dusted,
    strontium,
    tantalium,
    tcalloy,
    technetium,
    tennessine,
    th232,
    thorium_fuel,
    titanium,
    tungsten,
    u233,
    u235,
    u238,
    u238m2,
    unobtainium,
    uranium,
    uranium_fuel,
    verticium,
    weidanium,
    zirconium;

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
