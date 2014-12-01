dom = (document.getElementById) ? 1 : 0;

function activatefield(field){
  if (dom) {
    field.style.borderTop='thin solid #444;'
    field.style.borderLeft='thin solid #444;'
    field.style.borderRight='thin solid #ddd;'
    field.style.borderBottom='thin solid #ddd;'
    field.style.backgroundColor='#ffc';
  }
}
function deactivatefield(field){
  if (dom) {
    field.style.borderTop=''
    field.style.borderLeft=''
    field.style.borderRight=''
    field.style.borderBottom=''
    field.style.backgroundColor='';
  }
}