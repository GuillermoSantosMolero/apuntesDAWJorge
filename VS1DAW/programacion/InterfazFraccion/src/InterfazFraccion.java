/**
 * @author Guillermo Santos Molero
 *
 */
public interface InterfazFraccion {
	String sumar(int num2, int dem2);
	String restar(int num2, int dem2);
	int MaximoComunDivisor ();
	void simplificar ();
	int MinimoComunMultiplo (int num, int dem);
}
