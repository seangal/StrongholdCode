package componets;
import edu.wpi.first.wpilibj.VictorSP;

public class GearBox {

	private VictorSP forward, backwards;

    public GearBox(VictorSP forward, VictorSP backwards) {
		this.forward = forward;
		this.backwards = backwards;
	}
    public GearBox(int forwardPort, int backwardsPort) {
		this(new VictorSP(forwardPort), new VictorSP(backwardsPort));
	}

	public void set(double speed) {
		forward.set(speed);
		backwards.set(speed);
	}

	public double get() {
		return forward.get();
	}

	public void disable() {
		forward.disable();
		backwards.disable();
	}
}
