package actions;

import data.Tiles;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class AdjustHandler implements AdjustmentListener {


    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {

        if (e.getValue() > Tiles.oldVal) {
            Tiles.scroll += e.getValue()-Tiles.oldVal;
        } else{
            Tiles.scroll -= Tiles.oldVal -e.getValue();
        }

        Tiles.move(e.getValue());

    }
}
