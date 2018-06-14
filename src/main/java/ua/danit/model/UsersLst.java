package ua.danit.model;

import java.util.ArrayList;
import java.util.List;

public class UsersLst {
    public List<Users> get(){
        return new ArrayList<Users>(){{
            add(new Users("Dosja", "http://images-hdwallpapers.com/wp-content/uploads/2017/03/Beautiful-Indian-Girls-Photos-600x432.jpg"));
            add(new Users("Dasha", "http://cdn2.stylecraze.com/wp-content/uploads/2013/10/30.-Sana-Saeed_1.jpg"));
            add(new Users("Karina", "https://aishwaryarai.newssurge.com/aishwarya-pictures/d/665253-1/Beautiful+Indian+actresses+picture+of+Aishwarya+with+her+pretty+long+hair+with+long+side+bangs.JPG"));
            add(new Users("Mersedes", "https://thewondrous.com/wp-content/uploads/2015/05/Megan-Fox-beautiful-women-body.jpg"));
            add(new Users("Vyvarka", "http://www.findhealthtips.com/wp-content/uploads/2018/01/Kiara-Advani-Most-Beautiful-Indian-Girl.jpg"));
            add(new Users("Guba", "https://lifearoundasia.com/wp-content/uploads/2017/03/beautiful-vietnamese-women-1.jpg"));
            add(new Users("Braga", "https://www.wonderslist.com/wp-content/uploads/2012/11/Deepika-Sizzling-Body.jpg"));
            add(new Users("Sheron", "http://globalmedicalco.com/photos/globalmedicalco/13/63984.jpg"));
        }};
    }
}