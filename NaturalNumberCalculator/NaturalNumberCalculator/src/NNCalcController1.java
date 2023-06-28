import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * Controller class.
 *
 * @author Tan Qi Hao
 */
public final class NNCalcController1 implements NNCalcController {

    /**
     * Model object.
     */
    private final NNCalcModel model;

    /**
     * View object.
     */
    private final NNCalcView view;

    /**
     * Useful constants.
     */
    private static final NaturalNumber TWO = new NaturalNumber2(2),
            INT_LIMIT = new NaturalNumber2(Integer.MAX_VALUE);

    /**
     * Updates this.view to display this.model, and to allow only operations
     * that are legal given this.model.
     *
     * @param model
     *            the model
     * @param view
     *            the view
     * @ensures [view has been updated to be consistent with model]
     */
    private static void updateViewToMatchModel(NNCalcModel model,
            NNCalcView view) {

        NaturalNumber top = model.top();
        NaturalNumber bottom = model.bottom();
        boolean rootCheck = false;
        boolean subtractCheck = false;
        boolean divideCheck = false;
        boolean powerCheck = false;

        //Check the bottom to be smaller than top
        if (bottom.compareTo(top) <= 0) {
            subtractCheck = true;

        }

        //Update the subtract check
        view.updateSubtractAllowed(subtractCheck);

        //Check that the bottom is not zero
        if (!bottom.isZero()) {
            divideCheck = true;

        }

        //Update the divide check
        view.updateDivideAllowed(divideCheck);

        //Check the bottom of root within the max integer
        if (bottom.compareTo(INT_LIMIT) <= 0) {
            powerCheck = true;

        }

        //Update the power check
        view.updatePowerAllowed(powerCheck);

        //Check the bottom of root to be bigger and equal to 2
        //Check the bottom of root to be within max integer
        if (bottom.compareTo(INT_LIMIT) <= 0 && bottom.compareTo(TWO) >= 0) {
            rootCheck = true;

        }

        //Update the root check
        view.updateRootAllowed(rootCheck);

        //Update the top and bottom display
        view.updateTopDisplay(top);
        view.updateBottomDisplay(bottom);

    }

    /**
     * Constructor.
     *
     * @param model
     *            model to connect to
     * @param view
     *            view to connect to
     */
    public NNCalcController1(NNCalcModel model, NNCalcView view) {
        this.model = model;
        this.view = view;
        updateViewToMatchModel(model, view);
    }

    @Override
    public void processClearEvent() {
        /*
         * Get alias to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom.clear();
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processSwapEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        NaturalNumber temp = top.newInstance();
        temp.transferFrom(top);
        top.transferFrom(bottom);
        bottom.transferFrom(temp);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processEnterEvent() {

        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();

        //Copy bottom to top
        top.copyFrom(bottom);

        //Update the model and view
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processAddEvent() {

        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();

        //Add the bottom to top
        top.add(bottom);
        bottom.transferFrom(top);

        //Update the model and view
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processSubtractEvent() {

        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();

        //subtract the bottom with top
        //Transfer the top to bottom
        top.subtract(bottom);
        bottom.transferFrom(top);

        //Update the model and view
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processMultiplyEvent() {

        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();

        //multiple bottom with top
        //Transfer the answer to bottom
        top.multiply(bottom);
        bottom.transferFrom(top);

        //Update the model and view
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processDivideEvent() {

        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();

        //Divide the bottom with top
        //Transfer top to bottom
        //Transfer remainder to top
        NaturalNumber remainder = top.divide(bottom);
        bottom.transferFrom(top);
        top.transferFrom(remainder);

        //Update model and view
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processPowerEvent() {

        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();

        //make top to the power of bottom(Integer)
        //transfer top to bottom
        top.power(bottom.toInt());
        bottom.transferFrom(top);

        //Update model and view
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processRootEvent() {

        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();

        //find the root of top in bottom(Integer)
        //Transfer top to bottom
        top.root(bottom.toInt());
        bottom.transferFrom(top);

        //Update model and view
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processAddNewDigitEvent(int digit) {

        NaturalNumber bottom = this.model.bottom();

        //Multiple bottom by 10 and add the digit
        bottom.multiplyBy10(digit);

        //Update model and view
        updateViewToMatchModel(this.model, this.view);

    }

}
