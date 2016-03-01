package com.eic.cefet.cg.vetor.util;

import org.springframework.stereotype.Component;

import com.eic.cefet.cg.vetor.entidade.Vetor;
import com.eic.cefet.cg.vetor.excecao.VetorNuloException;

@Component
public class Operation {

	public static Vetor soma(Vetor u, Vetor v) {
		return new Vetor(u.getX() + v.getX(), u.getY() + v.getY(), u.getZ() + v.getZ());
	}

	public static Vetor diferenca(Vetor u, Vetor v) {
		return new Vetor(u.getX() - v.getX(), u.getY() - v.getY(), u.getZ() - v.getZ());
	}

	public static Vetor multiplicacao(double c, Vetor u) {
		return new Vetor(c * u.getX(), c * u.getY(), c * u.getZ());
	}

	public static Vetor vetorDefinido(Vetor u, Vetor v) {
		return new Vetor(v.getX() - u.getX(), v.getY() - u.getY(), v.getZ() - u.getZ());
	}

	public static boolean saoParalelos(Vetor u, Vetor v) {
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
		pMedio[2] = (a[2] + b[2])/2;

		return pMedio;
	}

	public static double distancia(double[] a, double[] b) {
		double moduloX = Math.pow(b[0] - a[0], 2);
		double moduloY = Math.pow(b[1] - a[1], 2);
		double moduloZ = Math.pow(b[2] - a[2], 2);

		return Math.sqrt(moduloX + moduloY + moduloZ);
	}

	public static double modulo(Vetor u) {
		double moduloX = Math.pow(u.getX(), 2);
		double moduloY = Math.pow(u.getY(), 2);
		double moduloZ = Math.pow(u.getZ(), 2);

		return Math.sqrt(moduloX + moduloY + moduloZ);
	}

	public static double produtoEscalar(Vetor u, Vetor v) {
		return (u.getX() * v.getX() + u.getY() * v.getY() + u.getZ() * v.getZ());
	}

	public static boolean saoOrtogonais(Vetor u, Vetor v) {
		if(produtoEscalar(u, v) == 0) {
			return true;
		} 

		return false;
	}

	public static double cos(Vetor u, Vetor v) {
		return produtoEscalar(u, v)/(modulo(u) * modulo(v));
	}

	public static double angulo(Vetor u, Vetor v) {
		return Math.acos(cos(u, v));
	}

	public static double cosDiretorX(Vetor u) {
		return u.getX()/modulo(u);
	}

	public static double cosDiretorY(Vetor u) {
		return u.getY()/modulo(u);
	}

	public static double cosDiretorZ(Vetor u) {
		return u.getZ()/modulo(u);
	}

	public static double anguloDiretorX(Vetor u) {
		return Math.acos(cosDiretorX(u));
	}

	public static double anguloDiretorY(Vetor u) {
		return Math.acos(cosDiretorY(u));
	}

	public static double anguloDiretorZ(Vetor u) {
		return Math.acos(cosDiretorZ(u));
	}

	public static Vetor projecao(Vetor u, Vetor v) throws VetorNuloException {
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
