package MyDiary.Core.Diary.Searcher;

import MyDiary.UI.CustomControls.SearcherControl;
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
