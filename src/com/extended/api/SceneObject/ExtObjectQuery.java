package com.extended.api.SceneObject;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.entity.SceneObject;

public class ExtObjectQuery {
    public SceneObject getNearestObject(String name, APIContext ctx) {
        return ctx.objects().query().nameMatches(name).results().nearest();
    }
    public SceneObject getNearestObject(String name, String action, APIContext ctx) {
        return ctx.objects().query().nameMatches(name).actions(action).results().nearest();
    }
    public SceneObject getNearestObject(int id, APIContext ctx) {
        return ctx.objects().query().id(id).results().nearest();
    }
    public SceneObject getNearestObject(int id, String action, APIContext ctx) {
        return ctx.objects().query().id(id).actions(action).results().nearest();
    }
}
