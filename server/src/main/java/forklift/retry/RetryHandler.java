package forklift.retry;

import forklift.consumer.MessageRunnable;
import forklift.consumer.ProcessStep;
import forklift.decorators.LifeCycle;

import java.io.FileNotFoundException;

public class RetryHandler {
    public RetryHandler() throws FileNotFoundException {
    }

    @LifeCycle(value=ProcessStep.Error, annotation=Retry.class)
    public void error(MessageRunnable mr, Retry retry) {
    }

    @LifeCycle(value=ProcessStep.Retrying, annotation=Retry.class)
    public void retrying(MessageRunnable mr) {
    }

    @LifeCycle(value=ProcessStep.MaxRetriesExceeded, annotation=Retry.class)
    public void maxRetries(MessageRunnable mr) {
    }
}