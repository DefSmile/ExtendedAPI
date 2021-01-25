package com.extended.api.npcs;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.entity.NPC;

public class ExtNPCQuery {

    public NPC getNearestNPC(String name, APIContext ctx) {
        return ctx.npcs().query().nameMatches(name).notInCombat().animation(-1).results().nearest();
    }
}
