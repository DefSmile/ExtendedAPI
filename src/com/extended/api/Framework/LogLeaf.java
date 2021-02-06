package com.extended.api.Framework;
import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.LeafTask;

public abstract class LogLeaf extends LeafTask {
    public LogLeaf(APIContext ctx) {
        super(ctx);
    }
    public abstract void doExecute();

    @Override
    public void execute() {
        ctx.script().logger().info("[Leaf] " + getClass().getSimpleName() + " --> Executed");

        doExecute();
    }

}
