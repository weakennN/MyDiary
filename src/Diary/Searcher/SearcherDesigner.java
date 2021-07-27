package Diary.Searcher;

import UI.CustomControls.SearcherControl;
import javafx.scene.layout.Region;

public class SearcherDesigner extends Region {

    private SearcherControl searcherControl;

    public SearcherDesigner() {
        this.searcherControl = new SearcherControl();
        super.getChildren().add(this.searcherControl);
    }

    public SearcherControl getSearcherControl() {
        return this.searcherControl;
    }
}
