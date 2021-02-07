package com.extended.api.Bank;

import com.epicbot.api.shared.model.Area;
import com.epicbot.api.shared.model.Tile;

public enum Banks {
    VARROCK_WEST("Varrock West", new Area(new Tile(3180, 3444, 0), new Tile(3185, 3437, 0)), false),
    VARROCK_EAST("Varrock East", new Area(new Tile(3250, 3424, 0), new Tile(3257, 3416, 0)), false),
    LUMBRIDGE("Lumbridge", new Area(new Tile(3207, 3219, 2), new Tile(3210, 3218, 2)), false),
    FALADOR_EAST("Falador East", new Area(new Tile(3010, 3358, 0), new Tile(3015, 3355, 0)),false),
    FALADOR_WEST("Falador West", new Area(new Tile(2943, 3371, 0), new Tile(2947, 3368, 0)),false),
    DRAYNOR("Draynor Village", new Area(new Tile(3092, 3245, 0), new Tile(3094, 3240, 0)),false),
    EDGEVILLE("Edgeville", new Area(new Tile(3092, 3496, 0), new Tile(3094, 3488, 0)),false),
    AL_KHARID("Al Kharid", new Area(new Tile(3269, 3170, 0), new Tile(3270, 3164, 0)),false),
    CASTLE_WARS("Castle Wars", new Area(new Tile(2437, 3087, 0), new Tile(2444, 3082, 0)),false),
    FEROX_ENCLAVE("Ferox Enclave", new Area(new Tile(3135, 3628, 0), new Tile(3134, 3630, 0)), false),
    BARBARIAN_OUTPOST("Barbarian Outpost", new Area(new Tile(2533, 3576, 0), new Tile(2537, 3572, 0)),true),
    JATIZSO("Jatizso", new Area(new Tile(2415, 3801, 0), new Tile(2418, 3800, 0)), true),
    CATHERBY("Catherby", new Area(new Tile(2806, 3440, 0), new Tile(2812, 3439, 0)), true),
    SEERS_VILLAGE("Seers Village",new Area(new Tile(2729, 3492, 0), new Tile(2722, 3491, 0)), true),
    YANILLE("Yanille", new Area(new Tile(2613, 3097, 0), new Tile(2614, 3088, 0)),true),
    CANIFIS("Canifis", new Area(new Tile(3509, 3481, 0), new Tile(3510, 3478, 0)), true);

    private String name;
    private Area bankArea;
    private boolean members;

    Banks(String name, Area bankArea, boolean members) {
        this.name = name;
        this.bankArea = bankArea;
        this.members = members;
    }
    public String getName() {
        return name;
    }
    public Area getBankArea() {
        return bankArea;
    }
    public boolean isMembers() {
        return members;
    }
}
