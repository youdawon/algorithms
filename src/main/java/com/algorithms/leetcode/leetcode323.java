/*
323. Number of Connected Components in an Undirected Graph
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
write a function to find the number of connected components in an undirected graph.

Example 1:

Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]

     0          3
     |          |
     1 --- 2    4

Output: 2
Example 2:

Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]

     0           4
     |           |
     1 --- 2 --- 3

Output:  1
Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected,
[0, 1] is the same as [1, 0] and thus will not appear together in edges.
*/

package com.algorithms.leetcode;

import java.util.List;
import java.util.ArrayList;

public class leetcode323{
	public static int getConnectedComponents(int[][] edges, int n){

		int count = 0;

		//인접 리스트 생성
		List<List<Integer>> graph = new ArrayList<>();
		for(int i=0; i<n; i++){
			graph.add(new ArrayList<>());
		}
		for(int[] edge : edges){
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		boolean visited[] = new boolean[n];

		for(int i=0; i<n; i++){
			if(!visited[i]){
				dfs(graph, visited, i);
				count++;
			}
		}


		return count;
	}

	public static void dfs(List<List<Integer>> graph, boolean[] visited, int num){

		visited[num] = true;

		for(int neighbour : graph.get(num)){
			if(visited[neighbour]){
				continue;
			}
			dfs(graph, visited, neighbour);
		}
	}

	public static void main(String[] args){

		int n = 5;
		// int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
		int[][] edges = {{0, 1}, {1, 2},{2, 3}, {3, 4}};
		System.out.println(getConnectedComponents(edges, n));
	}
}
