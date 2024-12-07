package project.logistics.util.logtracer.logtrace;


import project.logistics.util.logtracer.TraceStatus;

public interface LogTrace {
    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);
}
