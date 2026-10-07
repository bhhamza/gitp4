package com.entreprise.rh;

import com.entreprise.exceptions.MontantInvalideException;
public class Commercial extends Employe implements Augmentable{
	private double fixe;
	private double chiffreAffaires;

	public Commercial(String nom, double fixe, double chiffreAffaires, String agence)throws MontantInvalideException {
		super(nom, agence);
		if (fixe <= 0)
				throw new MontantInvalideException("fixe", fixe); // à remplacer à l'étape 4
		if (chiffreAffaires < 0)
			throw new MontantInvalideException("chiffreAffaires", chiffreAffaires);// à remplacer à l'étape 4
		this.fixe = fixe;
		this.chiffreAffaires = chiffreAffaires;
	}

	@Override
	public String getPoste(){
		return "Commercial";
	}

	@Override
	public double getSalaire() {
		return fixe + chiffreAffaires * 5 / 100;
	} // fixe + 5 % du CA

	@Override
	public String toString() {
		return getPoste() + "[" + super.toString() + ", fixe=" + fixe + ", chiffreAffaires=" + chiffreAffaires + "]";
	}
	@Override
    public void augmenter(double taux) throws MontantInvalideException {

        if (taux <= 0 || taux > TAUX_MAX) {
            throw new MontantInvalideException("taux", taux);
        }

        fixe = fixe + fixe * taux;
    }
}