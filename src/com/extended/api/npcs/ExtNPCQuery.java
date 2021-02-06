package com.extended.api.npcs;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.entity.NPC;
import com.epicbot.api.shared.query.NPCQueryBuilder;
import com.epicbot.api.shared.query.result.LocatableEntityQueryResult;

public class ExtNPCQuery {

    // Look up through names
    public NPC getNearestNPC(String name, APIContext ctx) { return ctx.npcs().query().nameMatches(name).results().nearest(); }

    public NPC getNearestNPC(String name, String action, APIContext ctx) { return ctx.npcs().query().nameMatches(name).actions(action).results().nearest(); }

    public NPC getNotInCombatNPC(String name, APIContext ctx) { return ctx.npcs().query().nameMatches(name).notInCombat().animation(-1).results().nearest(); }

    public NPC getNotInCombatNPC(String name, String action ,APIContext ctx) { return ctx.npcs().query().nameMatches(name).actions(action).notInCombat().animation(-1).results().nearest(); }

    public NPCQueryBuilder getNPC(String name, APIContext ctx) { return ctx.npcs().query().nameMatches(name); }

    public NPC getNearestNPC(int id, APIContext ctx) { return ctx.npcs().query().id(id).results().nearest(); }

    public NPC getNearestNPC(int id, String action, APIContext ctx) { return ctx.npcs().query().id(id).actions(action).results().nearest(); }

    public NPC getNotInCombatNPC(int id, APIContext ctx) { return ctx.npcs().query().id(id).notInCombat().animation(-1).results().nearest(); }

    public NPC getNotInCombatNPC(int id, String action ,APIContext ctx) { return ctx.npcs().query().id(id).actions(action).notInCombat().animation(-1).results().nearest(); }

    public NPCQueryBuilder getNPC(int id, APIContext ctx) { return ctx.npcs().query().id(id); }
}
