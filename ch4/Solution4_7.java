package ch4;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution4_7 {
	public Project[] findBuildorder(String[] projects, String[][] dependencies){
		Graph graph = buildGraph(projects,dependencies);
		return this.orderProjects(graph.getNodes());
	}
	public class Project {
		private ArrayList<Project> children = new ArrayList<Project>();
		private HashMap<String, Project> map = new HashMap<String, Project>();
		private String name;
		private int dependence = 0;

		public Project(String m) {
			this.name = m;
		}

		public void addNeighbor(Project node) {
			if (!map.containsKey(node.getName())) {
				children.add(node);
				node.incrementDependencies();
			}
		}

		public ArrayList<Project> getChildren() {
			return children;
		}

		public void setChildren(ArrayList<Project> children) {
			this.children = children;
		}

		public void incrementDependencies() {
			this.dependence++;
		}

		public void decrementDependencies() {
			this.dependence--;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getDependence() {
			return dependence;
		}

		public void setDependence(int dependence) {
			this.dependence = dependence;
		}
	}

	public class Graph {
		private ArrayList<Project> nodes = new ArrayList<Project>();
		private HashMap<String, Project> map = new HashMap<String, Project>();

		public Project getOrCreateNode(String name) {
			if (!map.containsKey(name)) {
				Project node = new Project(name);
				nodes.add(node);
				map.put(name, node);
			}
			return map.get(name);
		}

		public void addEdge(String startName, String endName) {
			Project start = this.getOrCreateNode(startName);
			Project end = this.getOrCreateNode(endName);
			start.addNeighbor(end);
		}
		
		public ArrayList<Project> getNodes(){
			return nodes;
		}
		
	}

	Graph buildGraph(String[] projects, String[][] dependencies) {
		Graph graph = new Graph();
		for (String project : projects) {
			graph.getOrCreateNode(project);
		}

		for (String[] dependency : dependencies) {
			String first = dependency[0];
			String second = dependency[1];
			graph.addEdge(first, second);
		}
		return graph;
	}

	/* Return a list of projects a correct build order */
	Project[] orderProjects(ArrayList<Project> projects) {
		Project[] order = new Project[projects.size()];

		/* add roots to the build order first */
		int endOfList = this.addNonDependent(order, projects, 0);

		int toBeProcessed = 0;
		while (toBeProcessed < order.length) {
			Project current = order[toBeProcessed];

			if (current == null)
				return null;

			ArrayList<Project> children = current.getChildren();
			for (Project child : children) {
				child.decrementDependencies();
			}

			endOfList = this.addNonDependent(order, children, endOfList);
		}
		return order;
	}

	/*
	 * A helper finction to insert projects with zerp dependencies into the
	 * order array. starting at the index offset
	 */
	public int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
		for (Project project : projects) {
			if (project.getDependence() == 0) {
				order[offset] = project;
				offset++;
			}
		}
		return offset;
	}

}
