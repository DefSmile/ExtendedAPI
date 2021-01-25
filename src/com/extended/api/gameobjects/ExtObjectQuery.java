package com.extended.api.gameobjects;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.entity.SceneObject;

public class ExtObjectQuery {
    public SceneObject getNearestObject(String name, APIContext ctx) {
        return ctx.objects().query().nameMatches(name).results().nearest();
    }
    public SceneObject getNearestObject(String name, String action, APIContext ctx) {
        return ctx.objects().query().nameMatches(name).actions(action).results().nearest();
    }
}
