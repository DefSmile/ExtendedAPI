package com.extended.api.Framework;
import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;

public abstract class LogBranch extends BranchTask {

    public LogBranch(APIContext ctx) {
        super(ctx);
    }
    protected abstract TreeTask doCreateSuccessTask(APIContext ctx);
    protected abstract TreeTask doCreateFailureTask(APIContext ctx);

    @Override
    protected TreeTask createSuccessTask(APIContext ctx) {
        ctx.script().logger().info(" [Branch][SUCCESS] --> " + getClass().getSimpleName());
        return doCreateSuccessTask(ctx);
    }

    @Override
    protected TreeTask createFailureTask(APIContext ctx) {
        ctx.script().logger().info(" [Branch][FAIL] --> " + getClass().getSimpleName());
        return doCreateFailureTask(ctx);
    }
}
