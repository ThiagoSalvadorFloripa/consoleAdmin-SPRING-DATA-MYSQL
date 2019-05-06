getTiposMedicamentos() {
    this.materialService.getTiposMedicamentos().subscribe(tipos => this.medicamentos = tipos)
  }

//---------Atendimento------------
  filterAtendimento(event){
    if(typeof event === "string" && event !== ""){
      this.tipoAtendimentoService.listarTipoAtendimentoMaterial(event).subscribe(data => {

        this.atendimentos = data
      })
    }
  }

  setAtendimento(event){
    console.log(event)
    this.complemento.atendimento = event
  }

  displayFnAtendimento(atendimento?: TipoAtendimento): string | undefined {
    console.log(atendimento)
    return atendimento ? atendimento.descricao : undefined;
}

//------Situacao processo----------

filterSituacaoProcesso(event){
  if(typeof event === "string" && event !== ""){
    this.situacaoProcessoService.listarSituacaoProcessoMaterial(event).subscribe(data => {
      this.situacoes = data
    })
  }
}

setSituacaoProcesso(event){
  console.log(event)
  this.complemento.situacao = event
}

displayFnSituacaoProcesso(situacao?: SituacaoProcesso): string | undefined {
  return situacao ? situacao.descricao : undefined;
}

//------TipoMedicamento----------

filterTipoMedicamento(event){
  if(typeof event === "string" && event !== ""){
    this.materialService.listarTipoMedicamentoMaterial(event).subscribe(data => {
      console.log(data)
      this.medicamentos = data
    })
  }
}

setTipoMedicamento(event){
  console.log(event)
  this.complemento.medicamento = event
}

displayFnTipoMedicamento(medicamento?: DescricaoModel): string | undefined {
  return medicamento ? medicamento.descricao : undefined;
}

//------Origem Medicamento----------

filterOrigem(event){
  if(typeof event === "string" && event !== ""){
    this.materialService.listarOrigemMaterial(event).subscribe(data => {
      console.log(data)
      this.origens = data
    })
  }
}

setOrigem(event){
  this.complemento.origem = event
}

displayFnOrigem(origem?: DescricaoModel): string | undefined {
  return origem ? origem.descricao : undefined;
}


  salvar() {
    console.log('estroiu')
    this.complemento.material.id = this.getMaterial().id

    this.materialService.salvarComplemento(this.complemento, this.complemento.material.id)
      .subscribe( result => {
        this.messageService.addToast(
          "Operação realizada com sucesso!", "", "success"),
          this.limpar()
        },
        error => this.messageService.addToast(
          error, "", "error")
      );
  }

  limpar(){
    this.complemento = <Complemento>{};
  }