package ua.danit.model;

import java.util.ArrayList;
import java.util.List;

public class UsersLst {
    public List<Users> get(){
        return new ArrayList<Users>(){{
            add(new Users("Dosja","http://images-hdwallpapers.com/wp-content/uploads/2017/03/Beautiful-Indian-Girls-Photos-600x432.jpg", 1));
            add(new Users("Dasha", "http://cdn2.stylecraze.com/wp-content/uploads/2013/10/30.-Sana-Saeed_1.jpg", 565));
            add(new Users("Karina", "https://aishwaryarai.newssurge.com/aishwarya-pictures/d/665253-1/Beautiful+Indian+actresses+picture+of+Aishwarya+with+her+pretty+long+hair+with+long+side+bangs.JPG", 45));
            add(new Users("Mersedes", "https://thewondrous.com/wp-content/uploads/2015/05/Megan-Fox-beautiful-women-body.jpg", 65));
            add(new Users("Vyvarka", "http://ginva.com/wp-content/uploads/2012/07/cute-and-beautiful-girls-wallpapers-057-600x375.jpg", 89));
            add(new Users("Guba", "https://lifearoundasia.com/wp-content/uploads/2017/03/beautiful-vietnamese-women-1.jpg", 3));
            add(new Users("Braga", "http://s2.favim.com/orig/34/beautiful-beauty-black-and-white-girl-model-Favim.com-273873.jpg", 100));
            add(new Users("Sheron", "http://globalmedicalco.com/photos/globalmedicalco/13/63984.jpg", 120 ));
        }};
    }
}