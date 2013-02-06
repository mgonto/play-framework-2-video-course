package controllers;

import play.Logger;
import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.Result;

public class LogRequestAction extends Action<LogRequest> {

    @Override
    public Result call(Context ctx) throws Throwable {
        Logger.info("The request was called " + ctx.request().uri());
        return delegate.call(ctx);
    }

}
