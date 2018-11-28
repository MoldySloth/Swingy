package rdejage.wethinkcode.swingy.model.characters;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Character {
    @NotNull
    protected Integer     level;
    @NotNull
    protected Integer     attack;
    @NotNull
    protected Integer     armor;
    @NotNull
    protected Integer     hitPoints;
}
