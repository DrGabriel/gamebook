
package utilizaveis;

import java.awt.image.BufferedImage;

public abstract class Item {
	
	private final BufferedImage itemImg;

	public Item(BufferedImage itemImg) {
		super();
		this.itemImg = itemImg;
	}

	public BufferedImage getItemImg() {
		return itemImg;
	}

}
