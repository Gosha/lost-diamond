package se.liu.ida.geoza435.tddc69.project.game;

/**
 * A single choice is first chosen and then executed.
 */
public interface Choice {

	public abstract void choose(Player player);

	public abstract void execute(Player player);
}
