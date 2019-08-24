package creatures;

import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.HugLifeUtils;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * An implementation of a fierce blue-colored predator.
 *
 * @author Jingyi
 */
public class Clorus extends Creature {

    /**
     * red color.
     */
    private int r;
    /**
     * green color.
     */
    private int g;
    /**
     * blue color.
     */
    private int b;

    /**
     * creates clorus with energy equal to E.
     */
    public Clorus(double e) {
        super("clorus");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }

    /**
     * creates a Clorus with energy equal to 1.
     */
    public Clorus() {
        this(1);
    }

    /**
     * The color() method for Cloruses should always
     * return the color red = 34, green = 0, blue = 231.
     */
    public Color color() {
        r = 34;
        b = 231;
        g = 0;
        return color(r, g, b);
    }

    /**
     * If a Clorus attacks another creature, it should gain that creature’s energy.
     */
    public void attack(Creature c) {
        energy = energy + c.energy();
    }

    /**
     * Clorus should lose 0.03 units of energy when moving. If you want to
     * to avoid the magic number warning, you'll need to make a
     * private static final variable. This is not required for this lab.
     */
    public void move() {
        energy = energy - 0.03;
    }


    /**
     * Clorus should lose 0.01 energy when staying.
     */
    public void stay() {
        energy = energy - 0.01;
    }

    /**
     * Clorus and their offspring each get 50% of the energy, with none
     * lost to the process. Now that's efficiency! Returns a baby
     * Clorus.
     */
    public Clorus replicate() {
        energy = energy / 2;
        return new Clorus(energy);
    }

    /**
     * Clorus take exactly the following actions based on NEIGHBORS:
     * 1. If there are no empty squares, the Clorus will STAY (even if there are
     *    Plips nearby they could attack since plip squares do not count as empty squares).
     * 2. Otherwise, if any Plips are seen, the Clorus will ATTACK one of them randomly.
     * 3. Otherwise, if the Clorus has energy greater than or equal to one,
     *    it will REPLICATE to a random empty square.
     * 4. Otherwise, the Clorus will MOVE to a random empty square.
     * <p>
     * Returns an object of type Action. See Action.java for the
     * scoop on how Actions work. See SampleCreature.chooseAction()
     * for an example to follow.
     */
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        // Rule 1
        Deque<Direction> emptyNeighbors = new ArrayDeque<>();
        Deque<Direction> plipNeighbors = new ArrayDeque<>();
        //boolean anyPlip = false;
        for (Direction d: neighbors.keySet()) {
            Occupant o = neighbors.get(d);
            if(o.name() == "empty") {
                emptyNeighbors.addLast(d);
            } else if (o.name() == "plip") {
                plipNeighbors.addLast(d);
            }
        }

        if (emptyNeighbors.size() == 0) { // FIXME
            return new Action(Action.ActionType.STAY);
        }

        // Rule 2
        // randomEntry(plipNeighbors)
        else if (plipNeighbors.size() != 0) {
            Direction pl = HugLifeUtils.randomEntry(plipNeighbors);
            return new Action(Action.ActionType.ATTACK, pl);
        }

        // Rule 3
        // HINT: randomEntry(emptyNeighbors)
        else if (energy >= 1) {
            Direction e = HugLifeUtils.randomEntry(emptyNeighbors);
            return new Action(Action.ActionType.REPLICATE, e);
        }

        // Rule 4
        Direction empt = HugLifeUtils.randomEntry(emptyNeighbors);
        return new Action(Action.ActionType.MOVE, empt);
    }
}

