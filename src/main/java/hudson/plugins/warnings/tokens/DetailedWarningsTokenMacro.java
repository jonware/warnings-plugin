package hudson.plugins.warnings.tokens;

import hudson.Extension;
import hudson.plugins.analysis.core.BuildResult;
import hudson.plugins.warnings.AggregatedWarningsResultAction;

/**
 * Provides a token that contain details of warnings.
 *
 * @author Benedikt Spranger
 * @deprecated replaced by classes of io.jenkins.plugins.analysis package
 */
@Deprecated
@Extension(optional = true)
public class DetailedWarningsTokenMacro extends AbstractDetailedTokenMacro {
    /**
     * Creates a new instance of {@link DetailedWarningsTokenMacro}.
     */
    @SuppressWarnings("unchecked")
    public DetailedWarningsTokenMacro() {
        super("WARNINGS_DETAILED", AggregatedWarningsResultAction.class);
    }

    @Override
    protected String evaluate(final BuildResult result) {
        return evalWarnings(result, result.getAnnotations()).replace("<br>", "\n");
    }
}
