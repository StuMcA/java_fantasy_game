package characters;

import behaviours.IPlay;
import playerActions.Creature;
import playerActions.Spell;

public class WizardsWarlocks implements IPlay {

        private Spell spell;
        private Creature creature;

        public WizardsWarlocks(Spell spell, Creature creature){
            this.spell = spell;
            this.creature = creature;
        }
    public void playerAction() {

    }
}
