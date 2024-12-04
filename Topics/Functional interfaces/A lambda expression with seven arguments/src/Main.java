import java.nio.file.Path;
import java.nio.file.PathMatcher;

// see NIO.2
PathMatcher matcher = new PathMatcher() {
    @Override
    public boolean matches(Path path) {
        return false;
    }
};