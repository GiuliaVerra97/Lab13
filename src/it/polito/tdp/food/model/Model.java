package it.polito.tdp.food.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.CibiComuni;
import it.polito.tdp.food.db.Condiment;
import it.polito.tdp.food.db.Food;
import it.polito.tdp.food.db.FoodDao;

public class Model {
	
	
	private Graph<Condiment, DefaultWeightedEdge> grafo;
	private Map<Integer, Condiment> condimenti;
	//private Map<Integer, Food> cibi;
	private List<Condiment> condimentiLista;
	//private List<Food> cibiLista;
	private FoodDao dao;
	private List<CibiComuni> archi;
	
	
	public Model() {
		
		
		condimenti=new HashMap<Integer, Condiment>();
		//cibi=new HashMap<Integer, Food>();
		condimentiLista=new ArrayList<Condiment>();
		//cibiLista=new ArrayList<Food>();
		dao=new FoodDao();
		archi=new ArrayList<CibiComuni>();
	}
	
	
	

	public void creaGrafo(int calorie) {
		
		grafo=new SimpleWeightedGraph<>(DefaultWeightedEdge.class);		
		condimentiLista=dao.condimentiCalorie(calorie, condimenti);
				
		Graphs.addAllVertices(grafo, condimentiLista);
		
		archi=dao.getArchi();
				
		for(CibiComuni a: archi) {
			
			if(condimenti.containsKey(a.getIngrediente1()) && condimenti.containsKey(a.getIngrediente2())) {
							
			Condiment c1=condimenti.get(a.getIngrediente1());
			Condiment c2=condimenti.get(a.getIngrediente2());
			
			Graphs.addEdgeWithVertices(this.grafo, c1, c2, (double) a.getPeso());
			
			}
			
		}
		
		System.out.println("Grafo creato con "+grafo.vertexSet().size()+" vertici "+grafo.edgeSet().size()+" archi ");
		
		
	}
	
	
	
	
	
	
	
	public String ordinaCalorie() {
		
		Collections.sort(condimentiLista);
		String s="";
		for(Condiment c: condimentiLista) {
			int numArchiEntranti=this.grafo.incomingEdgesOf(c).size();
			int numArchiUscenti=this.grafo.outgoingEdgesOf(c).size();
			s=s+c+" con calorie "+c.getCondiment_calories()+" è presente in "+(numArchiEntranti+numArchiUscenti)+" cibi\n ";
		}
		return s;
		
	}




	public List<Condiment> getCondimentiLista() {
		return condimentiLista;
	}




	public void setCondimentiLista(List<Condiment> condimentiLista) {
		this.condimentiLista = condimentiLista;
	}
	
	
	
	
	
	
	
	
	
	
	

}
