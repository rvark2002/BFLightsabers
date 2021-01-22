
package com.vark.lightsabers;

import java.util.HashMap;
import java.util.UUID;
import org.bukkit.entity.Player;

/**
 *
 * @Coding Legend Ritvik Varkhedkar
 */
class CM 

{
        public static HashMap<UUID, Double> st; //Saber Throw
        public static HashMap<UUID, Double> si; //SaberIgnite
        
        public static HashMap<UUID, Double> pr; //PikeRush

        
    
    
    public static void setupCooldown()
    {
        st = new HashMap<>();
        si = new HashMap<>();
        pr = new HashMap<>();
 
    }
    
    
    
    //setCooldown
    public static void setCooldown(Player player, int seconds)
    {
        double delay = System.currentTimeMillis() + (seconds*1000);
        st.put(player.getUniqueId(),delay);
    }
    
    public static void setCSI(Player player, int seconds)
    {
        double delay = System.currentTimeMillis() + (seconds*1000);
        si.put(player.getUniqueId(),delay);
    }
    
    public static void setPR(Player player, int seconds)
    {
        double delay = System.currentTimeMillis() + (seconds*1000);
        pr.put(player.getUniqueId(),delay);
    } 
    
    
    
    //getCooldown
    
    public static int getCooldown(Player player)
    {
        return Math.toIntExact(Math.round((st.get(player.getUniqueId())- System.currentTimeMillis())/1000));
    }
   
    public static int getCSI(Player player)
    {
        return Math.toIntExact(Math.round((si.get(player.getUniqueId())- System.currentTimeMillis())/1000));
    }
    
    public static int getPR(Player player)
    {
        return Math.toIntExact(Math.round((pr.get(player.getUniqueId())- System.currentTimeMillis())/1000));
    }

    
    
    //check cooldown
    public static boolean checkCooldown(Player player)
    {
        if(!st.containsKey(player.getUniqueId()) || st.get(player.getUniqueId()) <= System.currentTimeMillis()){
            return true;
        }
        return false;
    }
    
   
    
    //check cooldown
    public static boolean checkCSI(Player player)
    {
        if(!si.containsKey(player.getUniqueId()) || si.get(player.getUniqueId()) <= System.currentTimeMillis()){
            return true;
        }
        return false;
    }  
    

    public static boolean checkPR(Player player)
    {
        if(!pr.containsKey(player.getUniqueId()) || pr.get(player.getUniqueId()) <= System.currentTimeMillis()){
            return true;
        }
        return false;
    }  
    
    

}
