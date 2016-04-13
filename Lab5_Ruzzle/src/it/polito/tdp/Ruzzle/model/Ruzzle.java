package it.polito.tdp.Ruzzle.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.Ruzzle.DAO.ParolaDAO;

public class Ruzzle {
	
	List<ParolaRisultato> res = new ArrayList<>();
	ParolaDAO dao = new ParolaDAO();

	public List<ParolaRisultato> trovaParole(List<Casella> lettere) {
		
		res.clear();
		
		int passo = 0;
		ParolaRisultato parola = new ParolaRisultato("");
		
		faiPasso(passo, lettere, parola);
		
		System.out.println(res.toString());
		return res;
	}

	private void faiPasso(int passo, List<Casella> lettere, ParolaRisultato parola) {

		System.out.format("Sono al passo : %d , la parola è : '%s' e ho trovato : %d parole\n", passo, parola.getParola(), res.size());
		if (passo==16){
			
		}else{
			
			if (dao.isPresente(parola.getParola())==false){
				System.out.format("Non ci sono parole che iniziano con %s\n", parola.getParola());
				return;
			}
			
			if (parola.getParola().length()>= 2 && dao.isExactly(parola.getParola()))
				{
				ParolaRisultato parola2 = new ParolaRisultato(parola.toString());
				boolean[][] b = new boolean[4][4];
				for (int i = 0; i<= 3; i++){
					for (int j = 0; j<=3; j++){
						b[i][j] = parola.getPosizioni()[i][j];
					}
				}
				parola2.setPosizioni(b);
				res.add(parola2);
				}
			
			for(Casella c : lettere){
				
				System.out.format("Per la parola '%s' sto provando la lettera %c\n", parola.getParola() , c.getC());
				
				if (parola.getParola().length()==0 || this.confina(c , parola)){
					
					parola.setParola(parola.getParola()+c.getC());
					parola.getPosizioni()[c.getRiga()][c.getCol()]= true;
					faiPasso(passo +1, lettere, parola);
					//il problema è qua che tolgo le lettere!!
					parola.setParola(parola.getParola().substring(0,parola.getParola().length()-1));
					parola.getPosizioni()[c.getRiga()][c.getCol()]= false;
				}

			}

		}
	}

	private boolean confina(Casella c, ParolaRisultato parola) {
		
		
		int rigaC = c.getRiga();
		int colC = c.getCol();

		
		for (int i = 0; i<= 3; i++){
			for (int j = 0; j<=3; j++){
				if (parola.getPosizioni()[i][j]){
					if (rigaC ==i && colC == j)
						return false;
					if (rigaC == i && Math.abs(colC - j) ==1)
						return true;
					if (colC == j && Math.abs(rigaC - i)==1)
						return true;
					if ( Math.abs(colC - j) ==1&& Math.abs(rigaC - i)==1)
						return true;
				}
			}
		}
		return false;
	}
}
