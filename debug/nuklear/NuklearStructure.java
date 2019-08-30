package nuklear;

import java.util.*;

public interface NuklearStructure {
	List<Widget> widgets = new ArrayList<>();
	
	default void addWidgets(Widget ... widget ) {
		for (Widget wid : widget) {
			widgets.add(wid);
		}
 	}
	
	
}
