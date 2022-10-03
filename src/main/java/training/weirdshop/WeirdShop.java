package training.weirdshop;

class WeirdShop {
    private Item[] items;

    public WeirdShop(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            String name = item.name;
            int quality = item.quality;
            int sellIn = item.sellIn;

            if (!name.equals("Aged Brie") && !name.equals("Backstage Pass")) {
                if (quality > 0 && !name.equals("Gold Coin")) {
                    item.quality -= 1;
                }
            } else {
                managePassesAndBrie(item);
            }

            if (!name.equals("Gold Coin")) {
                item.sellIn -= 1;
            }

            if (item.sellIn < 0) {
                negativeSellIn(item);
            }
        }
    }

    public void negativeSellIn(Item item) {

        switch (item.name) {
            case "Aged Brie":
                if (item.quality < 50) {
                    item.quality++;
                }
                break;
            case "Backstage Pass":
                item.quality = 0;
                break;
            case "Gold Coin":
                break;
            default:
                if (item.quality > 0) {
                    item.quality --;
                }
        }
    }

    public void managePassesAndBrie(Item item) {
        if (item.quality < 50) {
            item.quality += 1;

            if (item.name.equals("Backstage Pass")) {
                if (item.sellIn < 12) {
                    item.quality += 1;
                }

                if (item.sellIn < 7) {
                    item.quality += 1;
                }
            }
        }
    }
}