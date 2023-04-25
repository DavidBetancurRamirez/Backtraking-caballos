package Caballo;

import java.util.Stack;


public class Caballo {
	private int n;
	private int[][] tablero;
	private final int[][] posiblesPasos = {{ 2, 1 },{ 1, 2 },{ -1, 2 },{ -2, 1 },{ -2, -1 },{ -1, -2 },{ 1, -2 },{ 2, -1 }};
	private Stack<int[][]> tableros = new Stack<int[][]>();
	
	public Caballo(int n) {
		this.n = n;
		this.tablero = new int[n][n];
	}

	public boolean resolver() {
		return resolver(0, 0, 1);
	}
	public boolean resolver(int fila, int columna, int cantidadSoluciones) {
		return resolver(fila, columna, 1, cantidadSoluciones);
	}
	private boolean resolver(int fila, int columna, int paso, int cantidadSoluciones) {
		tablero[fila][columna] = paso;
		
		if (paso == n * n) {
			int[][] copiaMatriz = copiaMatriz(tablero);
			tableros.push(copiaMatriz);
			
			if (tableros.size()==cantidadSoluciones)
				return true;		

			tablero[fila][columna] = 0;
			return false;
		}
		
		boolean encontrado = false;
		int i = 0;
		
		while (i < 8 && !encontrado) {
			int nuevaFila = fila + posiblesPasos[i][0];
			int nuevaColumna = columna + posiblesPasos[i][1];
			if (esValida(nuevaFila, nuevaColumna))
				encontrado = resolver(nuevaFila, nuevaColumna, paso + 1, cantidadSoluciones);
			i++;
		}
		
		if (!encontrado)
			tablero[fila][columna] = 0;
		
		return encontrado;
	}

	private boolean esValida(int fila, int columna) {
		return !(fila < 0 || fila >= n || columna < 0 || columna >= n || tablero[fila][columna] != 0);
	}

	public void imprimir() {
		System.out.println("Cantidad soluciones encontradas: "+tableros.size());
		int[][] t;
		while(!tableros.isEmpty()) {
			System.out.println("====================================");
			t = tableros.pop();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					System.out.printf("%4d", t[i][j]);
				System.out.println();
			}
			System.out.println("====================================\n");
		}
	}
	
	public int[][] copiaMatriz(int[][] original) {
		int[][] nueva = new int[original.length][original.length];
		for (int i = 0; i < nueva.length; i++) {
			for (int j = 0; j < nueva.length; j++)
				nueva[i][j] = original[i][j];
		}
		
		return nueva;
	}

	public static void main(String[] args) {
		Caballo caballo = new Caballo(8);
		caballo.resolver(0,0,3);
		caballo.imprimir();
	}

}