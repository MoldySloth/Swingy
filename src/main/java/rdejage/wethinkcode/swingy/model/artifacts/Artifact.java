package rdejage.wethinkcode.swingy.model.artifacts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Artifact {
    protected String    buffType;
    protected Integer   buffValue;

    public String   getBuffType() {
        return buffType;
    }

    public String   getArtifactName() { return this.getArtifactName(); }

    public Integer getBuffValue() { return buffValue; }
}
