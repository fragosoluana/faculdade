package com.eic.cefet.cg.vector.util;

import com.eic.cefet.cg.vector.entity.Vector;
import com.eic.cefet.cg.vector.exception.VetorNuloException;

public class Operation {

	public Vector soma(Vector u, Vector v) {
		return new Vector(u.getX() + v.getX(), u.getY() + v.getY(), u.getZ() + v.getZ());
	}

	public Vector diferenca(Vector u, Vector v) {
		return new Vector(u.getX() - v.getY(), u.getY() - v.getY(), u.getZ() - v.getZ());
	}

	public Vector multiplicacao(double c, Vector u) {
		return new Vector(c * u.getX(), c * u.getY(), c * u.getZ());
	}

	public Vector vetorDefinido(Vector u, Vector v) {
		return new Vector(v.getX() - u.getX(), v.getY() - u.getY(), v.getZ() - u.getZ());
	}

	public boolean saoParalelo(Vector u, Vector v) {
		double x = u.getX()/v.getX();
		double y = u.getY()/v.getY();
		double z = u.getZ()/v.getZ();

		if(x == y && y == z) {
			return true;
		} 

		return false;
	}

	public static double[] pontoMedio(double[] a, double[] b) {
		double[] pMedio = new double[3];

		pMedio[0] = (a[0] + b[0])/2;
		pMedio[1] = (a[1] + b[1])/2;
		pMedio[3] = (a[3] + b[3])/2;

		return pMedio;
	}

	public double modulo(double[] a, double[] b) {
		double moduloX = Math.pow(a[0] + b[0], 2);
		double moduloY = Math.pow(a[1] + b[1], 2);
		double moduloZ = Math.pow(a[3] + b[3], 2);

		return Math.sqrt(moduloX + moduloY + moduloZ);
	}

	public double modulo(Vector u) {
		double moduloX = Math.pow(u.getX(), 2);
		double moduloY = Math.pow(u.getY(), 2);
		double moduloZ = Math.pow(u.getZ(), 2);

		return Math.sqrt(moduloX + moduloY + moduloZ);
	}

	public double produtoEscalar(Vector u, Vector v) {
		return (u.getX() * v.getX() + u.getY() * v.getY() + u.getZ() * v.getZ());
	}

	public boolean saoOrtogonal(Vector u, Vector v) {
		if(produtoEscalar(u, v) == 0) {
			return true;
		} 

		return false;
	}

	public double cos(Vector u, Vector v) {
		return produtoEscalar(u, v)/(modulo(u) * modulo(v));
	}

	public double angulo(Vector u, Vector v) {
		return Math.acos(cos(u, v));
	}

	public double cosDiretorX(Vector u) {
		return u.getX()/modulo(u);
	}

	public double cosDiretorY(Vector u) {
		return u.getY()/modulo(u);
	}

	public double cosDiretorZ(Vector u) {
		return u.getZ()/modulo(u);
	}

	public double anguloDiretorX(Vector u) {
		return Math.acos(cosDiretorX(u));
	}

	public double anguloDiretorY(Vector u) {
		return Math.acos(cosDiretorY(u));
	}

	public double anguloDiretorZ(Vector u) {
		return Math.acos(cosDiretorZ(u));
	}

	//TODO incluir restricoes nos metodos anteriores

	public Vector projecao(Vector u, Vector v) throws VetorNuloException {
		if(modulo(u) != 0 && modulo(v) != 0) {
			double c = produtoEscalar(u, v)/produtoEscalar(v, v);

			return multiplicacao(c, v);
		} else {
			throw new VetorNuloException();
		}
	}
	
	//TODO produto vetorial
	
	//TODO produto misto
}
