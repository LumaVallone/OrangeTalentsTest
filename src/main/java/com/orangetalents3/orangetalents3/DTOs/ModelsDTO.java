package com.orangetalents3.orangetalents3.DTOs;

import java.util.List;

public class ModelsDTO {
	private List<FipeDefaultDTO> modelos;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((modelos == null) ? 0 : modelos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelsDTO other = (ModelsDTO) obj;
		if (modelos == null) {
			if (other.modelos != null)
				return false;
		} else if (!modelos.equals(other.modelos))
			return false;
		return true;
	}

	public List<FipeDefaultDTO> getModelos() {
		return modelos;
	}

	public void setModelos(List<FipeDefaultDTO> modelos) {
		this.modelos = modelos;
	}
}
