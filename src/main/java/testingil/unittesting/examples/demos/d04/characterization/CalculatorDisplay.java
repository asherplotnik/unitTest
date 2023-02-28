package testingil.unittesting.examples.demos.d04.characterization;

public class CalculatorDisplay {
	String display = "";
	int lastArgument = 0;
	int result = 0;
	Boolean newArgument = false;
	Boolean shouldReset = true;
	ExternalDsiplay ed;
	OperationType lastOperation;

	public void initExternalDisplay(ExternalDsiplay ed){
		this.ed = ed;
	}

	public void press(String key) {
		if (key.equals("+")) {
			lastOperation = OperationType.Plus;
			lastArgument = Integer.parseInt(display);
			newArgument = true;
		} else {
			if (key.equals("/")) {
				lastOperation = OperationType.Div;
				lastArgument = Integer.parseInt(display);
				newArgument = true;
			} else if (key.equals("*")) {
				lastOperation = OperationType.Mult;
				lastArgument = Integer.parseInt(display);
				newArgument = true;
			} else if (key.equals("-")) {
				lastOperation = OperationType.Min;
				lastArgument = Integer.parseInt(display);
				newArgument = true;
			} else if (key.equals("=")) {
				int currentArgument = Integer.parseInt(display);
				if (lastOperation == OperationType.Plus) {
					display = Integer.toString(lastArgument + currentArgument);
				}
				if (lastOperation == OperationType.Min) {
					display = Integer.toString(lastArgument - currentArgument);
				}
				if (lastOperation == OperationType.Mult) {
					display = Integer.toString(lastArgument * currentArgument);
				}

				if (lastOperation == OperationType.Div && currentArgument == 0) {
					display = "Division By Zero Error";
				} else if(lastOperation == OperationType.Div){
					display = Integer.toString(lastArgument / currentArgument);
				}
				shouldReset = true;
			} else {
				if (shouldReset) {
					display = "";
					shouldReset = false;
				}
				if (newArgument) {
					display = "";
					newArgument = false;
				}
				display += key;
			}
		}
		if (ed.isOn()) {
			ed.show(display);
		}
	}

	public String getDisplay() {
		if (display.equals(""))
			return "0";
		if (display.length() > 5)
			return "E";
		return display;
	}

}