package Caballo;


public class Caballo {
	private int n;
	private int[][] tablero;
	private int[][] posiblesPasos = {{ 2, 1 },{ 1, 2 },{ -1, 2 },{ -2, 1 },{ -2, -1 },{ -1, -2 },{ 1, -2 },{ 2, -1 } };

	public Caballo(int n) {
		this.n = n;
		this.tablero = new int[n][n];
	}

	public boolean resolver() {
		return resolver(0, 0);
	}
	public boolean resolver(int fila, int columna) {
		return resolver(fila, columna, 1);
	}
	private boolean resolver(int fila, int columna, int paso) {
		if (paso == n * n)
			return true;
		
		tablero[fila][columna] = paso;		
		boolean encontrado = false;
		int i = 0;
		
		while (i < 8 && !encontrado) {
			int nuevaFila = fila + posiblesPasos[i][0];
			int nuevaColumna = columna + posiblesPasos[i][1];
			if (esValida(nuevaFila, nuevaColumna))
				encontrado = resolver(nuevaFila, nuevaColumna, paso + 1);
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
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(tablero[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Caballo caballo = new Caballo(8);
		if (caballo.resolver()) {
			caballo.imprimir();
			System.out.println("");
		} else {
			System.out.println("No se encontró una solución");
		}
	}

}