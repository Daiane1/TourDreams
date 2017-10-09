package tourdreams.com.br;

/**
 * Created by Rachit on 21-07-2015.
 */
public class ItemPojo {

    int image_sub_item;
    String nome_sub_item;
    String local_sub_item;
    String checkin_sub_item;
    String checkout_sub_item;

    public ItemPojo(int image_sub_item, String nome_sub_item, String local_sub_item, String checkin_sub_item, String checkout_sub_item) {
        this.image_sub_item = image_sub_item;
        this.nome_sub_item = nome_sub_item;
        this.local_sub_item = local_sub_item;
        this.checkin_sub_item = checkin_sub_item;
        this.checkout_sub_item = checkout_sub_item;
    }

    public int getImage_sub_item() {
        return image_sub_item;
    }

    public void setImage_sub_item(int image_sub_item) {
        this.image_sub_item = image_sub_item;
    }

    public String getNome_sub_item() {
        return nome_sub_item;
    }

    public void setNome_sub_item(String nome_sub_item) {
        this.nome_sub_item = nome_sub_item;
    }

    public String getLocal_sub_item() {
        return local_sub_item;
    }

    public void setLocal_sub_item(String local_sub_item) {
        this.local_sub_item = local_sub_item;
    }

    public String getCheckin_sub_item() {
        return checkin_sub_item;
    }

    public void setCheckin_sub_item(String checkin_sub_item) {
        this.checkin_sub_item = checkin_sub_item;
    }

    public String getCheckout_sub_item() {
        return checkout_sub_item;
    }

    public void setCheckout_sub_item(String checkout_sub_item) {
        this.checkout_sub_item = checkout_sub_item;
    }
}
