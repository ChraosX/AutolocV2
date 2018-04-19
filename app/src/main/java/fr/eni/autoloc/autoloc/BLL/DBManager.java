package fr.eni.autoloc.autoloc.BLL;


import java.util.ArrayList;
import java.util.List;

import fr.eni.autoloc.autoloc.BO.Agence;
import fr.eni.autoloc.autoloc.BO.Agent;
import fr.eni.autoloc.autoloc.BO.Client;
import fr.eni.autoloc.autoloc.BO.Img;
import fr.eni.autoloc.autoloc.BO.Marque;
import fr.eni.autoloc.autoloc.BO.Model;
import fr.eni.autoloc.autoloc.BO.Personne;
import fr.eni.autoloc.autoloc.BO.TypeVehicule;
import fr.eni.autoloc.autoloc.BO.Vehicule;
import fr.eni.autoloc.autoloc.DAL.ParserList;
import fr.eni.autoloc.autoloc.DAL.Room.Database.AutolocDatabase;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.AgenceEntity;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.AgentEntity;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.ClientEntity;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.ImgEntity;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.ImgVehiculeEntity;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.MarqueEntity;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.ModelEntity;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.ParsableToBo;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.PersonneEntity;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.TypeVehiculeEntity;
import fr.eni.autoloc.autoloc.DAL.Room.Entity.VehiculeEntity;

public class DBManager {

    private   AutolocDatabase db;
    private static DBManager instance;

    public static DBManager getInstance(AutolocDatabase db) {

        if(instance == null){
            instance = new DBManager(db);
        }

        return instance;
    }





    private DBManager(AutolocDatabase dbe   ){
        db= dbe;
    }

    public List<Agence> getAll(){

        ParserList<Agence> p = new ParserList<Agence>();


        List<? extends ParsableToBo<Agence>> mm = db.agenceDAO().selectAll();

        return p.ParsToBo(mm);
    }

    public  Agence get(int id ){
        return db.agenceDAO().findById(id).toBo();
    }

    public void saveAgence(Agence a){

        if(a.getId()==0) {
            db.agenceDAO().insert(toAgenceEntity(a));
        }else{
            if(!a.equals(db.agenceDAO().findById(a.getId()).toBo())) {
                db.agenceDAO().update(toAgenceEntity(a));
            }
        }

        for ( Vehicule v:a.getVehicules()) {
            saveVehicule(v);

        }

    }

    public static  AgenceEntity toAgenceEntity(Agence a){
        AgenceEntity agenceEntity = new AgenceEntity();
        agenceEntity.id = a.getId();
        agenceEntity.adresse = a.getAdresse();
        agenceEntity.nom = a.getNom();

        return  agenceEntity;
    }

    public static ImgEntity toImgEntity(Img i){
        ImgEntity im = new ImgEntity();
        im.id =i.getId();
        im.description = i.getDescription();
        im.path = i.getPath();

        return im;
    }

    public  static ModelEntity toModelEntity(Model m){
        ModelEntity me = new ModelEntity();
        me.id = m.getId();
        me.nom = m.getNom();
        me.marqueId = m.getMarque().getId();
        me.imgId =m.getId();

        return  me;
    }

    public  static VehiculeEntity toVehiculeEntity(Vehicule v){
        VehiculeEntity ve = new VehiculeEntity();
        ve.agenceId = v.getAgence().getId();
        ve.disponibilite = v.getDisponibilite();
        ve.etatVehicule = v.getEtatVehicule().getId();
        ve.id = v.getId();
        ve.immatriculation = v.getImmatriculation();
        ve.prix = v.getPrix();
        ve.marqueId = v.getModel().getMarque().getId();
        ve.modelId = v.getModel().getId();
        ve.type_id = v.getModel().getType().getId();

        ve.puissance = v.getPuissance();

        return  ve;
    }

    public static MarqueEntity toMarqueEntity(Marque m){

        MarqueEntity me =  new MarqueEntity();

        me.id = m.getId();
        me.nom = m.getNom();

        return me;

    }

    public static TypeVehiculeEntity toTypeVehiculeEntity(TypeVehicule t){

        TypeVehiculeEntity te = new TypeVehiculeEntity();

        te.id = t.getId();
        te.nom = t.getNom();

        return te;

    }


   public  void saveVehicule( Vehicule v){
        if(v.getId()==0) {
            if (v.getModel().getId() == 0) {
                if (v.getModel().getMarque().getId() == 0) {
                    saveMarque(v.getModel().getMarque());

                }

                    saveType(v.getModel().getType());

                if (v.getModel().getImg() == null) {
                    v.getModel().setImg(db.imgDAO().findById(1).toBo());
                } else  {
                    saveImg(v.getModel().getImg());
                }


                saveModel(v.getModel());
                v.setId(db.vehiculeDAO().insert(toVehiculeEntity(v)));
            }

            if (v.getListPhotos().size() > 0) {
                for (Img i : v.getListPhotos()) {
                    if (i.getId() == 0) {
                        saveImg(i);
                    }
                    saveImgVehicule(i, v);

                }
            }
        }else{
                db.vehiculeDAO().update(toVehiculeEntity(v));
        }
   }

   public void saveMarque(Marque m){
        if(m.getId()==0) {
            m.setId(db.marqueDAO().insert(toMarqueEntity(m)));
        }else if(m.equals(db.marqueDAO().findById(m.getId()).toBo())){
            db.marqueDAO().update(toMarqueEntity(m));
        }
   }

   public void saveType(TypeVehicule t){
       if(t.getId()==0) {
           t.setId( db.typeVehiculeDAO().insert(toTypeVehiculeEntity(t)));
       }else if(t.equals(db.marqueDAO().findById(t.getId()).toBo())){
           db.typeVehiculeDAO().update(toTypeVehiculeEntity(t));
       }

   }

   public void saveImg(Img i){
       if(i.getId()==0) {
           i.setId(db.imgDAO().insert(toImgEntity(i)));
       }else if(i.equals(db.marqueDAO().findById(i.getId()).toBo())){
           db.imgDAO().update(toImgEntity(i));
       }

   }

   public void saveModel(Model m){
       if(m.getId()==0) {
           m.setId(db.modelDAO().insert(toModelEntity(m)));
       }else if(m.equals(db.marqueDAO().findById(m.getId()).toBo())){
           db.modelDAO().update(toModelEntity(m));
       }
       m.setId(db.modelDAO().insert(toModelEntity(m)));
   }

    public void saveImgVehicule(Img i, Vehicule v){
        ImgVehiculeEntity imm = new ImgVehiculeEntity();
        imm.imgId = i.getId();
        imm.marqueId = v.getModel().getMarque().getId();
        imm.typeId = v.getModel().getType().getId();
        imm.modelId = v.getModel().getId();
        imm.vehiculeId = v.getId();
        db.imgVehiculeEntityDAO().insert(imm);
    }


    public List<Agence> getAllAgence(){
        List<Agence>  result = new ArrayList<Agence>();
        for (AgenceEntity ae : db.agenceDAO().selectAll()){
            Agence a = ae.toBo();

            result.add(a);
        }

        return result;
    }

    public  void loadVehiculeAgence(Agence a){
        a.getVehicules().clear();
        for(VehiculeEntity ve : db.vehiculeDAO().selectByAgence(a.getId())){
            Vehicule v = ve.toBo();
            a.getVehicules().add(v);
        }
    }

    public  void loadAgenceAgent(Agence a){

        for(AgentEntity ae : db.agentDAO().findByAgence(a.getId())){
            PersonneEntity p = db.PersonneDAO().findById(ae.personneId);

            Agence agence = new Agence();
            agence.setNom(a.getNom());
            agence.setAdresse(a.getAdresse());
            agence.setId(a.getId());

            Agent ag = new Agent(agence);
            ag.setNom(p.nom);
            ag.setPrenom(p.prenom);
            ag.setEmail(p.email);
            ag.setSexe(p.sexe);
            ag.setTel(p.tel);
            ag.setPasswd(ae.passwd);

            a.getAgents().add(ag);
        }
    }

    public void saveAgent(Agent a){

        if(a.getId()==0){
            db.PersonneDAO().insert(toPersonneEntity(a));
            db.agentDAO().insert(toAgentEntity(a));

        }else {
            Agent test = db.agentDAO().findById(a.getId()).toBo();
            PersonneEntity p = db.PersonneDAO().findById(a.getId());
            test.setNom(p.nom);
            test.setPrenom(p.prenom);
            test.setTel(p.tel);
            test.setSexe(p.sexe);
            test.setEmail(p.email);

            if (!a.equals(test)){
                db.PersonneDAO().update(toPersonneEntity(a));
                db.agentDAO().update(toAgentEntity(a));
            }

        }
    }

    public void saveClient(Client c){
        if(c.getId()==0){
            db.PersonneDAO().insert(toPersonneEntity(c));
            db.clientDAO().insert(toClientEntity(c));

        }else {
            Agent test = db.agentDAO().findById(c.getId()).toBo();
            PersonneEntity p = db.PersonneDAO().findById(c.getId());
            test.setNom(p.nom);
            test.setPrenom(p.prenom);
            test.setTel(p.tel);
            test.setSexe(p.sexe);
            test.setEmail(p.email);

            if (!c.equals(test)){
                db.PersonneDAO().update(toPersonneEntity(c));
                db.clientDAO().update(toClientEntity(c));
            }

        }
    }

    public ClientEntity toClientEntity(Client c){

        ClientEntity cl = new ClientEntity();
        cl.adresse =  c.getAdresse();
        cl.personneId = c.getId();
        return cl;
    }

    public AgentEntity toAgentEntity(Agent a ){
        AgentEntity ae = new AgentEntity();
        ae.agenceId = a.getAgence().getId();
        ae.passwd = a.getPasswd();
        ae.personneId = a.getId();
        return  ae;
    }

    public void savePerosnne(PersonneEntity p){
        if(p.id ==0){
            db.PersonneDAO().insert(p);
        }else{
            db.PersonneDAO().update(p);
        }

    }

    public PersonneEntity toPersonneEntity(Personne p){
        PersonneEntity pe = new PersonneEntity();

        pe.id = p.getId();
        pe.email = p.getEmail();
        pe.nom = p.getNom();
        pe.prenom = p.getPrenom();
        pe.sexe = p.getSexe();
        pe.tel = p.getTel();

        return  pe ;
    }
    




}
